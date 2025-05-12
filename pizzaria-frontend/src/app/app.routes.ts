import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { OrderComponent } from './order/order.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { AboutComponent } from './about/about.component';

export const routes: Routes = [
    {path: "", pathMatch: "full", redirectTo: "home"},
    {path: "home", component: HomeComponent},
    {path: "menu", component: MenuComponent},
    {path: "order", component: OrderComponent},
    {path: "about", component: AboutComponent},
    {path: "**", component: NotfoundComponent}
];
