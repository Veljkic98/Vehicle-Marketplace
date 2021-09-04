import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSelectModule } from '@angular/material/select';

import { ToolbarComponent } from './toolbar/toolbar.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './features/login/login.component';
import { OffersHomeComponent } from './features/offer/offers-home/offers-home.component';
import { OffersComponent } from './features/offer/offers/offers.component';
import { FilterComponent } from './features/offer/filter/filter.component';
import { OfferComponent } from './features/offer/offer/offer.component';

@NgModule({
  declarations: [
    ToolbarComponent, 
    HomePageComponent, 
    LoginComponent, 
    OffersHomeComponent, 
    OffersComponent, 
    FilterComponent, OfferComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatSnackBarModule,
    MatSelectModule,
  ],
  providers: [
  ],
})
export class MaterialModule { }