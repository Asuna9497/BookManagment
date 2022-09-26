import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BookService } from 'src/app/book.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-searchbook',
  templateUrl: './searchbook.component.html',
  styleUrls: ['./searchbook.component.scss']
})
export class SearchbookComponent implements OnInit {
  constructor(public bookService: BookService, private snack: MatSnackBar,public loginService: LoginService) { }
  todaysDate: Date = new Date();
  categoryList: any = ['Fantasy', 'Science', 'Fiction', 'Dystopian', 'Romance', 'Detective',
    'Mystery', 'Horror', 'Thriller', 'Historical', 'Biography', 'Cooking', 'Inspirational',
    'Health'];
  selectedCategory = '';
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
  books: any = [];

  ngOnInit(): void {
  }

  getBooks() {
    const observable = this.bookService.getBook(this.selectedCategory, this.book.author.name,
      this.book.price, this.book.publisher);
    observable.subscribe(books => {
      this.books = books;
    },
      (error) => {
        console.log(error)
        this.snack.open('book not found serach with different criteria!!', '', {
          duration: 3000
        });
      })
  }

}
