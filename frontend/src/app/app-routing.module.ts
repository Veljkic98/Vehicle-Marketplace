import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/features/login/login.component';
// import { OffersComponent } from './components/features/offer/offers/offers.component';
import { OffersHomeComponent } from './components/features/offer/offers-home/offers-home.component';
import { HomePageComponent } from './components/home-page/home-page.component';

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
        path: 'offers-home',
        component: OffersHomeComponent,
        // children: [
        //   {
        //     path: 'offer',
        //     component: OfferComponent,
        //   }
        // ]
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
