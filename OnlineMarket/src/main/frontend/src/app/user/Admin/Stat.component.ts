import { Component,OnInit } from '@angular/core';
import { BuyerService } from '../../services/buyer.service'
import { Router } from '@angular/router'; 
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'show-stat',
    templateUrl:'template/stat.html',
    providers : [BuyerService]    
  })

  export class ShowStatComponent
  {
    ProdSum:number;
    ProdAvg:number;
    UserSum:number;
    UserAvg:number;
    constructor(private _userservice:BuyerService,private _route:Router,private route:ActivatedRoute)
    {}
    ngOnInit()
    {
        this._userservice.Psum().subscribe((ProdSum)=>{this.ProdSum=ProdSum});
        this._userservice.Pavg().subscribe((ProdAvg)=>{this.ProdAvg=ProdAvg});
        this._userservice.Usum().subscribe((UserSum)=>{this.UserSum=UserSum});
        this._userservice.Uavg().subscribe((UserAvg)=>{this.UserAvg=UserAvg});
        
    }
  }