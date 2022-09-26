import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BookService } from 'src/app/book.service';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-buybook',
  templateUrl: './buybook.component.html',
  styleUrls: ['./buybook.component.scss']
})
export class BuybookComponent implements OnInit {
  books: any = [];
  isBought = false;

  constructor(public bookService: BookService, private snack: MatSnackBar, public login : LoginService) { }

  ngOnInit(): void {
    this.getAllBooks();
  }

  public getAllBooks() {
    const observable = this.bookService.getAllBooks();
    observable.subscribe(books => {
      this.books = books;
    },
      (error) => {
        console.log(error)
        this.snack.open('No books available to buy!!', '', {
          duration: 3000
        });
      })
  }

  public buyBook(book: any) {
    const observable = this.bookService.buyBook(book, this.login.getUser().id);
    observable.subscribe((response) => {
      console.log(response);
      Swal.fire('success!!', 'Book purchased successfully', 'success');
    },
      (error) => { // error handler
        console.log(error)
        this.snack.open('error while buying book!! Please try again!', '', {
          duration: 3000  
        });
      }
    )
  }

}
