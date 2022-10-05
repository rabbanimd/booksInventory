import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConstants } from 'src/environments/environment';
import { BookResponsePaged } from '../Response/Book';

@Injectable({
  providedIn: 'root'
})
export class ContentService {

  private constants = AppConstants;
  constructor(private http:HttpClient) { }
  
  fetchAllBooksPage(pageNo = 0, pageSize = 0):Observable<BookResponsePaged> {
    let url = this.constants.SERVER_ADDRESS + `:`+ this.constants.SERVER_PORT+"/api/books/";
    console.log("connecting server : "+url);
    return this.http.get<BookResponsePaged>(url,{params:{"pageNo":pageNo, "pageSize":pageSize}});
  }

  fetchAllBooks() : Observable<BookResponsePaged> {
    let url = this.constants.SERVER_ADDRESS + `:`+ this.constants.SERVER_PORT+"/api/books/";
    console.log("connecting server : "+url);
    return this.http.get<BookResponsePaged>(url);
  }
}
