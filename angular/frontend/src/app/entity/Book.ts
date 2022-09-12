import Author from '../entity/Author';
export default class Book{
    constructor(public content:string, public logo: string,  public publisher:string, public title:string, 
        public category:string,public price:number, public author: Author, public publishedDate:Date,
         public active:boolean){}
}