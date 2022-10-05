import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  searchByList = ['Book Name', 'ID', 'Author Name'];
  searchBy = 'Book Name';
  searchValue = '';
  errorMessage = '';

  onClickedSearch(formData:any) {
    this.errorMessage = '';
    if(formData.search ===null || formData.search === undefined || formData.search.length===0)
    {
      this.errorMessage = 'Enter text to search';
      return;
    }
    this.searchValue = formData.search.trim();
    this.searchBy = formData.searchBy;
    // console.log(formData);
    // filer search value
    if(this.searchBy === "ID" && !this.isValidNumber()) {
        // not a valid number
        this.errorMessage = 'Enter number for ID';
        return;
    }else if(this.searchBy !== "ID" && this.isValidNumber()){
        this.errorMessage = 'Enter text for book/author';
        return;
    }
  }

  isValidNumber() {
    if(typeof this.searchValue !== 'string'){
      return false;
    }
    return Number.isInteger(Number(this.searchValue));
  }
}
