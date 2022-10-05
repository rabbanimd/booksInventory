export class BookResponse {
    id:number;
    bookName:string;
    authorName:string;
    pages:number;
    isbn:string;
    description:string;
    
    constructor(
        id:number,
        bookName:string,
        authorName:string,
        pages : number,
        isbn : string,
        description : string
    ) {
        this.id = id;
        this.authorName = authorName;
        this.bookName = bookName;
        this.pages = pages;
        this.isbn = isbn;
        this.description = description;
    }
};

export interface BookResponsePaged {
    pageNo:number;
    pageSize:number;
    totalPages:number;
    isLast:boolean;
    books:BookResponse[];
};