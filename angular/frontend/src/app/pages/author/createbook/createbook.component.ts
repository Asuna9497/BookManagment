import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BookService } from 'src/app/book.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-createbook',
  templateUrl: './createbook.component.html',
  styleUrls: ['./createbook.component.scss']
})
export class CreatebookComponent implements OnInit {
  todaysDate: Date = new Date();
  categoryList: any = ['Fantasy', 'Science', 'Fiction', 'Dystopian', 'Romance', 'Detective',
  'Mystery', 'Horror', 'Thriller', 'Historical', 'Biography', 'Cooking', 'Inspirational',
  'Health'];
  selectedCategory = '';


  constructor(public bookService: BookService, private snack: MatSnackBar, public loginService: LoginService) { }
  book = {
    content: '',
    logo: '',
    publisher: '',
    title: '',
    category: this.selectedCategory, 
    price: 0,
    author: {
      id: this.loginService.getUser().id,
      name: this.loginService.getUser().username
    },
    publishedDate: Date,
    active: false
  }
  ngOnInit(): void {
  }

  createBook() {
    console.log('inside createBook');
    if (this.book.logo == null || this.book.logo == '') {
      this.snack.open('Logo is required !!', '', {
        duration: 3000
      });
      return;
    }
    if (this.selectedCategory == null || this.selectedCategory == '') {
      this.snack.open('category is required !!', '', {
        duration: 3000
      });
      return;
    } else{
      this.book.category = this.selectedCategory;
    }
    if (this.book.content == null || this.book.content == '') {
      this.snack.open('content is required !!', '', {
        duration: 3000
      });
      return;
    }
    if (this.book.price == null || this.book.price < 0) {
      this.snack.open('price is required and should be greater than zero!!', '', {
        duration: 3000
      });
      return;
    }
    if (this.book.publisher == null || this.book.publisher == '') {
      this.snack.open('publisher is required !!', '', {
        duration: 3000
      });
      return;
    }
    if (this.book.author.name == null || this.book.author.name == '') {
      this.snack.open('author is required !!', '', {
        duration: 3000
      });
      return;
    }
    if (this.book.publishedDate == null) {
      this.snack.open('published Date is required !!', '', {
        duration: 3000
      });
      return;
    }
    //Ajax call 
    console.log(this.loginService.getUser().id);
    const observable = this.bookService.createBook(this.loginService.getUser().id, this.book);
    observable.subscribe((response) => {
      console.log(response);
      Swal.fire('success!!', 'Book saved successfully', 'success');
    },
      (error) => { // error handler
        console.log(error)
        this.snack.open('something went wrong!!', '', {
          duration: 3000
        });
      }
    )
  }

  

}
