import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router'; 
import { ActivatedRoute } from '@angular/router'
import { BuyerService } from '../../services/buyer.service'
import { StoreEntity } from '../StoreEntity'

@Component({
    selector: 'seller-home',
    templateUrl:'template/SellerHome.html',
    providers : [BuyerService] 
  })

  export class SellerHomeComponent
  {
    private name:string;
    private stores:StoreEntity[];
    private storesColla:StoreEntity[];
    constructor(private _userservice:BuyerService,private _route:Router,private route:ActivatedRoute)
    {}
    ngOnInit()
    {
        this.name=this.route.snapshot.params['name'];
        this._userservice.getStores(this.name).subscribe((stores)=>{this.stores=stores});
        this._userservice.getcollas(this.name).subscribe((storesColla)=>{this.storesColla=storesColla})
        
        
    }
    Add1()//add store
    {
        this._route.navigate(['/AddStore/'+this.name]);
    }
    Add2(st:string) //addprod
    {
        this._route.navigate(['/AddProd/'+this.name+'/'+st]);
    }
    Add3(st:string) //addcolla
    {
        this._route.navigate(['/AddColla/'+this.name+'/'+st]);
    }
    Add4(st:string)//showprodO
    {
        this._route.navigate(['/ShowProdsO/'+st]);
    }
    Add5(st:string)  //add prodd bta3t l colla 
    {
        this._route.navigate(['/AddProdc/'+this.name+'/'+st]);
    }
    Add6(st:string)//showprodC
    {
        this._route.navigate(['/ShowProdsC/'+st+'/'+this.name]);
    }
    Add7()//history
    {
        this._route.navigate(['/history/'+this.name]);
        
    }
    Add8()//buy
    {
        this._route.navigate(['/buyerHome/'+this.name]);  
    }
  }