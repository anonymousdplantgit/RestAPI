import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { UserModule } from './user/user.module';
import { RessourceModule } from './ressource/ressource.module';
import { HttpModule } from '@angular/http';
import { ProductModule } from './product/product.module';
import { Ng4LoadingSpinnerModule } from 'ng4-loading-spinner';
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    UserModule,
    RessourceModule,
    ProductModule,
    Ng4LoadingSpinnerModule
   ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
