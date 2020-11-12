import {LoginComponent} from 'src/app/login/login.component';
import {LogoutComponent} from 'src/app/logout/logout.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainPageComponent} from './main-page/main-page.component';
import {RouteGuardService} from './service/route-guard.service';
import {ErrorComponent} from './error/error.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'welcome/:name', component: MainPageComponent, canActivate:[RouteGuardService]},
  { path: 'logout', component: LogoutComponent },

  { path: '**', component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
