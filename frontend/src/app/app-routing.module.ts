import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/features/login/login.component';
import { AddNewComponent } from './components/features/offer/add-new/add-new.component';
// import { OffersComponent } from './components/features/offer/offers/offers.component';
import { OffersHomeComponent } from './components/features/offer/offers-home/offers-home.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginGuard } from './guards/login.guard';

const routes: Routes = [
  {
    path: '',
    component: HomePageComponent,
    children: [
      {
        path: 'login',
        component: LoginComponent,
        // canActivate: [LoginGuard]
      },
      {
        path: 'offers-home/:which',
        component: OffersHomeComponent,
      },
      {
        path: 'offers-home-mine/:which',
        component: OffersHomeComponent,
        // canActivate: [LoginGuard],
        // data: { expectedRoles: 'ROLE_USER' }
      },
      {
        path: 'add-new',
        component: AddNewComponent,
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    onSameUrlNavigation: 'reload'
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
