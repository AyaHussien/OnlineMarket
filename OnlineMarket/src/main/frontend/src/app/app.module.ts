import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { routers } from './app.routing'
import { HttpModule } from '@angular/http';
import { AppComponent }  from './app.component';
import { FormsModule} from '@angular/forms'
import { BuyerRegisterComponent }  from './user/Buyer/BuyerRegister.component';
import { BuyerLoginComponent }  from './user/Buyer/BuyerLogin.component';
import { SellerRegisterComponent }  from './user/Seller/SellerRegister.component';
import { SellerLoginComponent }  from './user/Seller/SellerLogin.component';
import { AdminLoginComponent } from './user/Admin/AdminLogin.component';
import { BuyerHomeComponent } from './user/Buyer/BuyerHome.component';
import { SellerHomeComponent } from './user/Seller/SellerHome.component';
import { AdminHomeComponent } from './user/Admin/AdminHome.component';
import { SysProdComponent } from './user/Admin/SysProd.component';
import { BrandComponent } from './user/Admin/Brand.component';
import { AddStoreComponent }from './user/Seller/AddStore.component';
import { AddProdComponent } from './user/Seller/AddProd.component';
import { ShowStatComponent } from './user/Admin/Stat.component';
import { AddCollaComponent } from './user/Seller/AddColla.component';
import { ShowProdsOComponent } from './user/Seller/ShowProdsO.component';
import { ShowProdsCComponent } from './user/Seller/ShowProdsC.component';
import { EditOComponent } from './user/Seller/EditO.component';
import { EditCComponent } from './user/Seller/EditC.component';
import { DeleteOComponent } from './user/Seller/DeleteO.component';
import { DeleteCComponent } from './user/Seller/DeleteC.component';
import { AddProdCComponent }from './user/Seller/AddProdC.component';
import { HistoryComponent }from './user/Seller/History.component';


@NgModule({
  imports:      [ BrowserModule,routers,HttpModule,FormsModule ],
  declarations: [ AppComponent,BuyerRegisterComponent,BuyerLoginComponent,SellerRegisterComponent
                 ,SellerLoginComponent,AdminLoginComponent,BuyerHomeComponent,SellerHomeComponent
                 ,AdminHomeComponent,SysProdComponent,BrandComponent,AddStoreComponent,AddProdComponent
                 ,ShowStatComponent,AddCollaComponent,ShowProdsOComponent,ShowProdsCComponent
                ,EditOComponent,DeleteOComponent,DeleteCComponent,EditCComponent,AddProdCComponent
                ,HistoryComponent],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
