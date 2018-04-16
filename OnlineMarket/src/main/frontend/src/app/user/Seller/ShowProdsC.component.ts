import { Component,OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { BuyerService } from '../../services/buyer.service';
import { Router } from '@angular/router'; 
import { ProductEntity } from'../ProductEntity'

@Component({
    selector: 'show-prods2',
    templateUrl:'template/ShowProds2.html',
    providers : [BuyerService]    
    
  })

  export class ShowProdsCComponent
  {
      private prods:ProductEntity[];    
      private st:string
      private collaname:string
      constructor(private route:ActivatedRoute,private _userservice:BuyerService,private _route:Router){}
      ngOnInit()
      {
          this.st=this.route.snapshot.params['st'];
          this.collaname=this.route.snapshot.params['cname'];          
          this._userservice.showProds(this.st).subscribe((prods)=>{this.prods=prods});
          
      }
      Add2(id:number)
      {
          this._route.navigate(['/EditC/'+this.prods[id-1].name+'/'+this.prods[id-1].storeName+'/'+this.collaname]);
      }
      Add3(id:number)
      {
          console.log(id);
          this._route.navigate(['/DeleteC/'+this.prods[id-1].name+'/'+this.prods[id-1].storeName+'/'+this.collaname]);
      }
      
 }