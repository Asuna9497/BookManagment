import { Component, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

import { HttpClientModule } from "@angular/common/http";
import { RouterModule, Routes } from '@angular/router';
import { SearchbookformComponent } from './searchbookform/searchbookform.component';
import { CreatebookComponent } from './createbook/createbook.component';


const routes: Routes = [
  { path: 'searchbookform', component: SearchbookformComponent },
  { path: 'createbook', component: CreatebookComponent },

]
@NgModule({
  declarations: [
    AppComponent,
    SearchbookformComponent,
    CreatebookComponent
  ],
  imports: [
    BrowserModule, 
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
