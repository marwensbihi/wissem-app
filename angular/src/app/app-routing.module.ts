import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientListComponent } from './client-list/client-list.component';
import { CommandeComponent } from './commande/commande.component';
import { CommandesListComponent } from './commandes-list/commandes-list.component';
import { GerantDetailsComponent } from './gerant-details/gerant-details.component';
import { GerantListComponent } from './gerant-list/gerant-list.component';
import { HomeComponent } from './home/home.component';
import { MesCommandesComponent } from './mes-commandes/mes-commandes.component';
import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "login", component: SignInComponent },
  { path: "register", component: SignUpComponent },
  { path: "restaurants", component: RestaurantListComponent },
  { path: "restaurants/:id", component: RestaurantDetailsComponent },
  { path: "commande", component: CommandeComponent },
  { path: "mes-commandes", component: MesCommandesComponent },
  { path: "gerants", component: GerantListComponent },
  { path: "gerants/:id", component: GerantDetailsComponent },
  { path: "clients", component: ClientListComponent },
  { path: "tous-les-commandes", component: CommandesListComponent },




  { path: '**', redirectTo: '' }

];

/*
restaurants*
restaurants/id* -> INC produits + suppl -> MODALS
restaurants/id/edit -> MODAL
restaurants/add -> MODAL

produits/add -> MODAL
produits/id/edit -> MODAL

my-restaurant*

gerants*
gerants/id*
gerants/id/edit -> MODAL
gerants/add -> MODAL

livreurs*
livreurs/id*
livreurs/id/edit -> MODAL
livreurs/add -> MODAL

clients*
clients/id*
clients/id/edit -> MODAL
clients/add -> MODAL

fournisseurs*
fournisseurs/id*
fournisseurs/id/edit -> MODAL
fournisseurs/add -> MODAL

commande*

home*

sign-in*
sign-up*
*/

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
