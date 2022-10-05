import { Component, OnInit } from '@angular/core';
import { BookResponse, BookResponsePaged } from 'src/app/Response/Book';
import { ContentService } from 'src/app/services/content.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private content:ContentService) { }

  maxScrollLength = 10;

  booksPage ?: BookResponsePaged;
  nOfResult = 0;
  pageSize = 10;
  totalPages = 1;
  isLast = false;
  result :any;
  pageNo = 0;
  booksList : Array<BookResponse> = [];

  ngOnInit(): void {
    this.getBooksPage();
  //     console.log(this.booksPage);
  //     // data.books?.forEach((book)=>this.booksPage?.books?.push(new BookResponse(book.id, book.bookName, book.authorName, book.pages, book.isbn, book.description)))
  //   },err=>{
  //     console.log("ERROR : "+ err);
  //   });
  //   // console.log("page no : "+this.booksPage?.pageNo);
  }

  onScroll(ev:any) {
    if(this.isLast || this.maxScrollLength === 2){
      return;
    }
    this.maxScrollLength++;
    this.pageNo++;
    console.log("scrolled : "+ev+"page : "+this.pageNo);

    this.getBooksPage();
  }

  getBooksPage() {
    this.content.fetchAllBooksPage(this.pageNo, this.pageSize).subscribe(
      (data:BookResponsePaged)=> {
        this.booksPage = {
          pageNo:data.pageNo,
          pageSize:data.pageSize,
          totalPages:data.totalPages,
          isLast : data.isLast,
          books:data.books
        };
        this.totalPages = this.booksPage.totalPages;
        this.isLast = this.booksPage.isLast;
        this.booksPage.books.forEach((book:BookResponse)=>this.booksList.push(book));
        this.nOfResult += this.booksPage.pageSize;
      },
        err=>{
          console.log("ERROR : "+ err);
        }
      );
  }


  
}