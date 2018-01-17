import { Component, OnInit ,OnDestroy} from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product.service';
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
    private productService: ProductService) { }

  ngOnInit() {
    this.getAll();


    this.form = new FormGroup({
      productId : new FormControl(),
      ref: new FormControl('', Validators.required),
      label: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      buyingPrice: new FormControl('', Validators.required),
      sellingPrice: new FormControl('', Validators.required)
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
    this.productService.findAll().subscribe(
      products => {
        this.products = products;
        console.log(products);
      },
      err => {
        console.log(err);
      }
 
    );
  }
 
  delete(product: Product) {
    if (product) {
      this.productService.deleteById(product.productId).subscribe(
        res => {
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
