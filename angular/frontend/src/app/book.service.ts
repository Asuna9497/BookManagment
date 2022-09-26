import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
const API_URL = "http://localhost:8082/api/v1/digitalbooks/";
@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(public client: HttpClient) { }

  createBook(authorId: number, book: any) {
    return this.client.post(API_URL + "author/" + authorId + "/books", book)
  }

  getBook(category: string, authorName: string, price: number, publisher: string) {
    return this.client.get(API_URL + "books/search?category=" + category + "&author=" + authorName +
      "&price=" + price + "&publisher=" + publisher);
  }

  getPurchasedBooks(emailId: string) {
    return this.client.get(API_URL+"Readers/"+ emailId + "/books");
  }

  buyBook(purchasedBook: any, userId: number){
    return this.client.post(API_URL + "books/"+ userId +"/buy/" , purchasedBook )

  }
  getAllBooks(){
    console.log("inside get all books" );
    return this.client.get(API_URL + "Readers/books");  
  }

}
