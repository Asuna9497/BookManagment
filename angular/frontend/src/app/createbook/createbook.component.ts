import { Component, OnInit } from '@angular/core';
import Book from '../entity/Book';
import Author from '../entity/Author';
import { BookService } from '../book.service';
import Swal from 'sweetalert2';
import { MatSnackBar} from '@angular/material/snack-bar';

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

  constructor(public bookService: BookService, private snack: MatSnackBar) { }

  ngOnInit(): void {
  }
  createBook() {
    console.log('inside createBook');
    if(this.book.logo==null || this.book.logo==''){
      this.snack.open('Logo is required !!', '', {
        duration: 3000
      });
      return;
    }
    if(this.book.category==null || this.book.category==''){
      this.snack.open('category is required !!', '', {
        duration: 3000
      });
      return;
    }
    if(this.book.content==null || this.book.content==''){
      this.snack.open('content is required !!', '', {
        duration: 3000
      });
      return;
    }
    if(this.book.price==null || this.book.price < 0){
      this.snack.open('price is required and should be greater than zero!!', '', {
        duration: 3000
      });
      return;
    }
    if(this.book.publisher==null || this.book.publisher==''){
      this.snack.open('publisher is required !!', '', {
        duration: 3000
      });
      return;
    }
    if(this.book.author.name==null || this.book.author.name==''){
      this.snack.open('author is required !!', '', {
        duration: 3000
      });
      return;
    }
    if(this.book.publishedDate==null){
      this.snack.open('published Date is required !!', '', {
        duration: 3000
      });
      return;
    }
    //Ajax call 
    const observable = this.bookService.createBook(this.author.id, this.book);
    observable.subscribe((response) => {
      console.log(response);
      Swal.fire('successfully done!!', 'Book saved successfully', 'success');
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
