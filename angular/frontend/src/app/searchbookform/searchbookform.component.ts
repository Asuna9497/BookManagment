import { Component, OnInit } from '@angular/core';
import Book from '../entity/Book';
import Author from '../entity/Author';
import { BookService } from '../book.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-searchbookform',
  templateUrl: './searchbookform.component.html',
  styleUrls: ['./searchbookform.component.scss']
})
export class SearchbookformComponent implements OnInit {
  todaysDate: Date = new Date();
  author: Author = new Author(1, "Shashank");
  categoryList: any = ['Fantasy', 'Science', 'Fiction', 'Dystopian', 'Romance', 'Detective',
  'Mystery', 'Horror', 'Thriller', 'Historical', 'Biography', 'Cooking', 'Inspirational',
  'Health'];
  selectedCategory= '';
  book: Book = new Book("this is Science book", "Science.com", "eiusmod", "birds", this.selectedCategory, 600, this.author, this.todaysDate, true);
  books: any = [];
 
  constructor(public bookService: BookService, private snack:MatSnackBar) { }

  ngOnInit(): void {
  }

  getBooks() {
    const observable = this.bookService.getBook(this.selectedCategory, this.book.author.name,
      this.book.price, this.book.publisher);
    observable.subscribe(books => {
      this.books = books;
    },
    (error)=>{
      console.log(error)
      this.snack.open('something went wrong!!', '', {
        duration: 3000
      });
    })
  }

}
