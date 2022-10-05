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

  booksPage ?: BookResponsePaged;
  // pageNo = 0;
  // pageSize = 10;
  // totalPages = 1;
  // isLast = false;
  result :any;

  ngOnInit(): void {
    this.content.fetchAllBooks().subscribe((data:BookResponsePaged)=> {
      this.booksPage = {
        pageNo:data.pageNo,
        pageSize:data.pageSize,
        totalPages:data.totalPages,
        isLast : data.isLast,
        books:data.books
      }
      console.log(this.booksPage);
      // data.books?.forEach((book)=>this.booksPage?.books?.push(new BookResponse(book.id, book.bookName, book.authorName, book.pages, book.isbn, book.description)))
    },err=>{
      console.log("ERROR : "+ err);
    });
    // console.log("page no : "+this.booksPage?.pageNo);
  }

}
