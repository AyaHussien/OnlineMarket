import { Component,OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { BuyerService } from '../../services/buyer.service';
import { Router } from '@angular/router'; 
import { ProductEntity } from'../ProductEntity'

@Component({
    selector: 'show-prods',
    templateUrl:'template/ShowProds1.html',
    providers : [BuyerService]    
    
  })

  export class ShowProdsOComponent
  {
      private prods:ProductEntity[];    
      private st:string
      constructor(private route:ActivatedRoute,private _userservice:BuyerService,private _route:Router){}
      ngOnInit()
      {
          this.st=this.route.snapshot.params['st'];
          this._userservice.showProds(this.st).subscribe((prods)=>{this.prods=prods});
          
      }
      Add2(id:number)
      {
          this._route.navigate(['/EditO/'+this.prods[id-1].name+'/'+this.prods[id-1].storeName]);
      }
      Add3(id:number)
      {
          this._route.navigate(['/DeleteO/'+this.prods[id-1].name+'/'+this.prods[id-1].storeName]);
      }
      
 }