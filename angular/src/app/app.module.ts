import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { GerantListComponent } from './gerant-list/gerant-list.component';
import { GerantDetailsComponent } from './gerant-details/gerant-details.component';
import { ClientDetailsComponent } from './client-details/client-details.component';
import { ClientListComponent } from './client-list/client-list.component';
import { ProductListComponent } from './product-list/product-list.component';
import { FooterComponent } from './footer/footer.component';
import { CommandeComponent } from './commande/commande.component';
import { MyRestaurantComponent } from './my-restaurant/my-restaurant.component';
import { LivreursListComponent } from './livreurs-list/livreurs-list.component';
import { FournisseursComponent } from './fournisseurs/fournisseurs.component';
import { FournisseurDetailsComponent } from './fournisseur-details/fournisseur-details.component';
import { MesCommandesComponent } from './mes-commandes/mes-commandes.component';

import { ToastModule } from 'primeng/toast';
import { HttpClientModule } from '@angular/common/http';
import { MessageService } from 'primeng/api';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';

import {ConfirmPopupModule} from 'primeng/confirmpopup';
import {ConfirmationService} from 'primeng/api';
import { CommandesListComponent } from './commandes-list/commandes-list.component';
import {DialogModule} from 'primeng/dialog';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    SignInComponent,
    SignUpComponent,
    RestaurantDetailsComponent,
    ProductDetailsComponent,
    RestaurantListComponent,
    GerantListComponent,
    GerantDetailsComponent,
    ClientDetailsComponent,
    ClientListComponent,
    ProductListComponent,
    FooterComponent,
    CommandeComponent,
    MyRestaurantComponent,
    LivreursListComponent,
    FournisseursComponent,
    FournisseurDetailsComponent,
    MesCommandesComponent,
    CommandesListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ToastModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    ConfirmPopupModule,
    DialogModule,
    
  ],
  providers: [MessageService, ConfirmationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
