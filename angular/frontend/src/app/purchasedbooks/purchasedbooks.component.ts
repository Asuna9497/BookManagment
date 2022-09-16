import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import Reader from '../entity/Reader';

@Component({
  selector: 'app-purchasedbooks',
  templateUrl: './purchasedbooks.component.html',
  styleUrls: ['./purchasedbooks.component.scss']
})
export class PurchasedbooksComponent implements OnInit {

  reader: Reader = new Reader(5,'reader1','reader1.r@r.com');
  constructor(public bookService:BookService) { }
  purchasedBooks:any=[];
  ngOnInit(): void {
    this.getPurchasedBooks();
  }

 public getPurchasedBooks(){
    const observable = this.bookService.getPurchasedBooks(this.reader.email);
    observable.subscribe(purchasedBooks=>{
      this.purchasedBooks = purchasedBooks;
    })
  }

}
