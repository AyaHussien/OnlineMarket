import { ModuleWithProviders } from '@angular/core';
import { RouterModule,Routes } from '@angular/router';
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
import { AddProdComponent }from './user/Seller/AddProd.component';
import { AddProdCComponent }from './user/Seller/AddProdC.component';
import { ShowStatComponent } from './user/Admin/Stat.component';
import { AddCollaComponent } from './user/Seller/AddColla.component';
import { ShowProdsOComponent } from './user/Seller/ShowProdsO.component';
import { ShowProdsCComponent } from './user/Seller/ShowProdsC.component';
import { EditOComponent } from './user/Seller/EditO.component';
import { EditCComponent } from './user/Seller/EditC.component';
import { DeleteOComponent } from './user/Seller/DeleteO.component';
import { DeleteCComponent } from './user/Seller/DeleteC.component';
import { HistoryComponent }from './user/Seller/History.component';



const AppRoute:Routes=[
    {path:'buyerRegister',component:BuyerRegisterComponent},
    {path:'buyerLogin',component:BuyerLoginComponent},
    {path:'sellerRegister',component:SellerRegisterComponent},
    {path:'sellerLogin',component:SellerLoginComponent},
    {path:'adminLogin',component:AdminLoginComponent},
    {path:'adminHome',component:AdminHomeComponent},
    {path:'buyerHome/:name',component:BuyerHomeComponent},
    {path:'sellerHome/:name',component:SellerHomeComponent},
    {path:'SysProd',component:SysProdComponent},
    {path:'Brand',component:BrandComponent},
    {path:'AddStore/:name',component:AddStoreComponent},
    {path:'AddProd/:name/:st',component:AddProdComponent},
    {path:'AddProdc/:name/:st',component:AddProdCComponent},    
    {path:'AddColla/:name/:st',component:AddCollaComponent},
    {path:'EditO/:name/:st',component:EditOComponent}, 
    {path:'EditC/:pname/:st/:cname',component:EditCComponent},
    {path:'DeleteO/:name/:st',component:DeleteOComponent},   
    {path:'DeleteC/:pname/:st/:cname',component:DeleteCComponent},        
    {path:'ShowProdsO/:st',component:ShowProdsOComponent},    
    {path:'ShowProdsC/:st/:cname',component:ShowProdsCComponent},  
    {path:'history/:name',component:HistoryComponent},      
    {path:'Stat',component:ShowStatComponent}
  ];

export const routers:ModuleWithProviders=RouterModule.forRoot (AppRoute); 