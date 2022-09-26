import { Component, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

import { HttpClientModule } from "@angular/common/http";
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HomeComponent } from './pages/home/home.component';
import {MatCardModule} from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { authInterceptorProviders } from './services/auth.interceptor';
import { MatTableModule } from '@angular/material/table';
import { AuthorDashboardComponent } from './pages/author/author-dashboard/author-dashboard.component';
import { ReaderDashboardComponent } from './pages/reader/reader-dashboard/reader-dashboard.component'
import { ReaderGuard } from './services/reader.guard';
import { AuthorGuard } from './services/author.guard';
import { SidebarComponent } from './pages/author/sidebar/sidebar.component';
import { MatListModule } from '@angular/material/list';
import { ProfileComponent } from './pages/profile/profile.component';
import { WelcomeComponent } from './pages/author/welcome/welcome.component';
import { CreatebookComponent } from './pages/author/createbook/createbook.component';
import { ReaderSidebarComponent } from './pages/reader/reader-sidebar/reader-sidebar.component';
import { WelcomeReaderComponent } from './pages/reader/welcome-reader/welcome-reader.component';
import { ReaderProfileComponent } from './pages/reader/reader-profile/reader-profile.component';
import { SerachPurchasedBookComponent } from './pages/reader/serach-purchased-book/serach-purchased-book.component';
import { SearchbookComponent } from './pages/author/searchbook/searchbook.component';
import { BuybookComponent } from './pages/reader/buybook/buybook.component';


const routes: Routes = [
  { path: 'signup', component: SignupComponent },
  { path: 'login', component: LoginComponent },
  { path: '', component: HomeComponent },
  {
    path: 'author', component: AuthorDashboardComponent, canActivate: [AuthorGuard],
    children: [
      {
        path: '',
        component: WelcomeComponent
      },
      {
        path: 'profile',
        component: ProfileComponent
      },
      {
        path: 'createBook',
        component: CreatebookComponent
      },
      {
        path: 'searchbook',
        component: SearchbookComponent
      }
    ]
  },
  { path: 'reader', component: ReaderDashboardComponent, canActivate: [ReaderGuard],
  children: [
    {
      path: '',
      component: WelcomeReaderComponent
    },
    {
      path: 'profile',
      component: ReaderProfileComponent
    },
    {
      path: 'searchbook',
      component: SerachPurchasedBookComponent
    },
    {
      path: 'buybook',
      component: BuybookComponent,
      children:[
        {
          path:'buy',
          component:BuybookComponent
        }
      ]
    }
  ]
 }

]
@NgModule({
  declarations: [
    AppComponent,
    CreatebookComponent,
    HeaderComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    AuthorDashboardComponent,
    ReaderDashboardComponent,
    SidebarComponent,
    WelcomeComponent,
    ProfileComponent,
    ReaderSidebarComponent,
    WelcomeReaderComponent,
    ReaderProfileComponent,
    SerachPurchasedBookComponent,
    SearchbookComponent,
    BuybookComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    BrowserAnimationsModule,
    MatInputModule,
    MatFormFieldModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    MatListModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
