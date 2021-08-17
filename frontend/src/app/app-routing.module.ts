import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  // {
  //   path: '',
  //   component: HomePageComponent,
  //   children: [
  //     {
  //       path: 'login',
  //       component: LoginComponent,
  //       canActivate: [LoginGuard]
  //     },
  //   ]
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
