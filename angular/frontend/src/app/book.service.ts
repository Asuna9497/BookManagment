import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Book from './entity/Book';
const API_URL = "http://localhost:8082/api/v1/digitalbooks/";
@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(public client: HttpClient) { }

  createBook(authorId: number, book: Book) {
    return this.client.post(API_URL + "author/" + authorId + "/books", book)
  }

  getBook(category: string, authorName: string, price: number, publisher: string) {
    return this.client.get(API_URL + "books/search?category=" + category + "&author=" + authorName +
      "&price=" + price + "&publisher=" + publisher);
  }
}
