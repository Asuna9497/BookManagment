import { Component, OnInit } from '@angular/core';
import Book from '../entity/Book';
import Author from '../entity/Author';
import { BookService } from   '../book.service'
@Component({
  selector: 'app-bookform',
  templateUrl: './bookform.component.html',
  styleUrls: ['./bookform.component.scss']
})
export class BookformComponent implements OnInit {
  todaysDate: Date = new Date();
  author:Author = new Author (1, "Shashank");
  book:Book= new Book("this is Science book", "Science.com","eiusmod","birds","Science",600,this.author,this.todaysDate,true);
  constructor(public bookService:BookService) { }

  createBook(){
    console.log('inside createBook');
    //Ajax call
    const observable = this.bookService.createBook(this.author.id, this.book);
    observable.subscribe((response)=>{
      console.log(response);
    })
  }
  ngOnInit(): void {
  }

}
