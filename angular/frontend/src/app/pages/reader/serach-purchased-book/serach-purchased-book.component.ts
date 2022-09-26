import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BookService } from 'src/app/book.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-serach-purchased-book',
  templateUrl: './serach-purchased-book.component.html',
  styleUrls: ['./serach-purchased-book.component.scss']
})
export class SerachPurchasedBookComponent implements OnInit {

  constructor(public bookService: BookService, private snack: MatSnackBar,public loginService: LoginService) { }
  book = {
    content: '',
    logo: '',
    publisher: '',
    title: '',
    category: '', 
    price: 0,
    author: {
      id: null,
      name: ''
    },
    publishedDate: Date,
    active: false
  }
  books: any = [];

  ngOnInit(): void {
  }

  getPurchasedBooks() {
    const observable = this.bookService.getPurchasedBooks(this.loginService.getUser().email);
    observable.subscribe(books => {
      this.books = books;
    },
      (error) => {
        console.log(error)
        this.snack.open('There are no purchased books!!', '', {
          duration: 3000
        });
      })
  }

}
