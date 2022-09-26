export default class PurchasedBook {
    constructor(public content: string, public logo: string, public publisher: string, public title: string,
        public category: string, public price: number, public author: User, public publishedDate: Date,
        public active: boolean) { }
}