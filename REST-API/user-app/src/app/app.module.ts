import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { UserModule } from './user/user.module';
import { RessourceModule } from './ressource/ressource.module';
import { HttpModule } from '@angular/http';
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    UserModule,
    RessourceModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
