import { Component, OnInit ,OnDestroy} from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product.service';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { Product } from '../product';
import {FormControl, FormGroup, Validators} from "@angular/forms";
@Component({
  selector: 'app-product-management',
  templateUrl: './product-management.component.html',
  styleUrls: ['./product-management.component.css'],
  providers: [ProductService]
})
export class ProductManagementComponent implements OnInit,OnDestroy {
  product: Product;
  form: FormGroup;
  private products: Product[];
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService,
    private spinnerService: Ng4LoadingSpinnerService) { }

  ngOnInit() {

    this.getAll();


    this.form = new FormGroup({
      productId : new FormControl(),
      ref: new FormControl(null, Validators.required),
      label: new FormControl(null, Validators.required),
      description: new FormControl(null, Validators.required),
      buyingPrice: new FormControl(null, Validators.required),
      sellingPrice: new FormControl(null, Validators.required)
    });
  }
  ngOnDestroy(): void {
  }

  onSubmit() {
    if (this.form.valid) {
        let product: Product = new Product(
          this.form.controls['productId'].value,
          this.form.controls['ref'].value,
          this.form.controls['label'].value,
          this.form.controls['description'].value,
          this.form.controls['buyingPrice'].value,
          this.form.controls['sellingPrice'].value);
        this.productService.save(product).subscribe();

      }
      this.form.reset();
      this.getAll();
}
  getAll() {
    this.spinnerService.show();
    this.productService.findAll().subscribe(
      products => {
        this.products = products;
        console.log(products);
        this.spinnerService.hide();
      },
      err => {
        console.log(err);
      }
 
    );
    
  }
 
  delete(product: Product) {
    this.spinnerService.show();
    if (product) {
      this.productService.deleteById(product.productId).subscribe(
        res => {
          this.spinnerService.hide();
          this.getAll();
          console.log('delete product '+ product.productId+' done');
        }
      );
    }
  }
  
  edit(product: Product) {
    console.log(product);
    this.form.patchValue({
      productId: product.productId,
      ref: product.ref,
      label: product.label,
      description: product.description,
      buyingPrice:product.buyingPrice,
      sellingPrice:product.sellingPrice
  });
  
  }
  reset() {
    this.form.reset();
 
  }

}
