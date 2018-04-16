import { Component,OnInit } from '@angular/core';
import { ProductEntity } from'../ProductEntity'
import { Router } from '@angular/router'; 
import { ActivatedRoute } from '@angular/router';
import { BuyerService } from '../../services/buyer.service';

@Component({
    selector: 'buyer-home',
    templateUrl:'template/BuyerHome.html',
    providers : [BuyerService] 
  })

  export class BuyerHomeComponent
  {
    private name:string;
    private prods:ProductEntity[];
    constructor(private _userservice:BuyerService,private _route:Router,private route:ActivatedRoute)
    {}
    ngOnInit()
    {
        this.name=this.route.snapshot.params['name'];
        this._userservice.getprods().subscribe((prods)=>{this.prods=prods})
        
    }
    Add(v1:number,v2:number)
    {
        console.log(v1);
        this._userservice.buy(this.prods[v1-1].name,v2,this.prods[v1-1].storeName,this.name).subscribe((user)=>{
            console.log(user)
            if(user==-1)
                {
                    console.log("l2aaaaa"+ this.prods[v1-1].storeName)
                    this._route.navigate(['/buyerHome/'+this.name]);
                }
                
            else
                {
                    console.log("l product b2a bta3k ya zmele "+this.prods[v1-1].storeName)
                    this._route.navigate(['/buyerHome/'+this.name]);
                }
                 
        });
               
    }
  }