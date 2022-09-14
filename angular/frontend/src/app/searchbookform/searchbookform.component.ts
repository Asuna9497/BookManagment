import { Component, OnInit } from '@angular/core';
import Book from '../entity/Book';
import Author from '../entity/Author';
import { BookService } from '../book.service';

@Component({
  selector: 'app-searchbookform',
  templateUrl: './searchbookform.component.html',
  styleUrls: ['./searchbookform.component.scss']
})
export class SearchbookformComponent implements OnInit {
  todaysDate: Date = new Date();
  author: Author = new Author(1, "Shashank");
  book: Book = new Book("this is Science book", "Science.com", "eiusmod", "birds", "Science", 600, this.author, this.todaysDate, true);
  books: any = [];
  categoryList: any = ['Fantasy', 'Science', 'Fiction', 'Dystopian', 'Romance', 'Detective',
  'Mystery', 'Horror', 'Thriller', 'Historical', 'Biography', 'Cooking', 'Inspirational',
  'Health'];

  constructor(public bookService: BookService) { }

  ngOnInit(): void {
  }

  getBooks() {
    const observable = this.bookService.getBook(this.book.category, this.book.author.name,
      this.book.price, this.book.publisher);
    observable.subscribe(books => {
      this.books = books;
    })
  }

}
