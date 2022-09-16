import { Component, OnInit } from '@angular/core';
import Book from '../entity/Book';
import Author from '../entity/Author';
import { BookService } from '../book.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-createbook',
  templateUrl: './createbook.component.html',
  styleUrls: ['./createbook.component.scss']
})
export class CreatebookComponent implements OnInit {
  todaysDate: Date = new Date();
  author: Author = new Author(1, "Shashank");
  book: Book = new Book("this is Science book", "Science.com", "eiusmod", "birds", "Science", 600, this.author, this.todaysDate, true);
  categoryList: any = ['Fantasy', 'Science', 'Fiction', 'Dystopian', 'Romance', 'Detective',
    'Mystery', 'Horror', 'Thriller', 'Historical', 'Biography', 'Cooking', 'Inspirational',
    'Health'];

  constructor(public bookService: BookService) { }

  ngOnInit(): void {
  }
  createBook() {
    console.log('inside createBook');
    //Ajax call 
    const observable = this.bookService.createBook(this.author.id, this.book);
    observable.subscribe((response) => {
      console.log(response);
      Swal.fire('successfully done!!', 'Book saved successfully', 'success');
    },
      (error) => { // error handler
        alert('Something went wrong');
      }
    )
  }

}
