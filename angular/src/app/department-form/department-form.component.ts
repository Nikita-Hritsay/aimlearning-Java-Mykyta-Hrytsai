import { Component, OnInit } from '@angular/core';
import {Department} from "../models/Department";
import {DepartmentService} from "../service/department/department.service";
import {ActivatedRoute, Router} from "@angular/router";
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators
} from "@angular/forms";

@Component({
  selector: 'app-department-form',
  templateUrl: './department-form.component.html',
  styleUrls: ['../style/main.css']
})
export class DepartmentFormComponent implements OnInit {

  department?: Department;
  departmentForm = new FormGroup({
    name: new FormControl("", Validators.required),
    address: new FormControl("", Validators.required)
  });

  constructor(private departmentService: DepartmentService, private activateRout: ActivatedRoute,
              private router: Router) {
    this.departmentForm = new FormBuilder().group({
      id: [this.department?.id],
      name: [null, Validators.required],
      address: [null, Validators.required]
    });
    this.departmentService.getById(Number.parseInt(<string>this.activateRout.snapshot.paramMap.get("id"))).subscribe((data)=>{
      this.department = data;
      this.departmentForm.get('name')?.setValue(this.department?.name);
      this.departmentForm.get('address')?.setValue(this.department?.address);
    });
  }

  onSubmit(){
    if(this.departmentForm.valid){
      const departmentResult = new Department(
        this.department == null ? 0: this.department?.id,
        String(this.departmentForm.get('name')?.value),
        String(this.departmentForm.get('address')?.value));
      this.departmentService.saveOrUpdate(departmentResult).subscribe(()=>{
        this.router.navigate(["/departments"]);
      });
    }
  }

  getErrors(formControlName: string): boolean {
    const value = this.departmentForm.get(formControlName)!;
    return value?.invalid && (value?.dirty || value?.touched);
  }


  ngOnInit(): void {

  }

  /*nameValidator(control: AbstractControl): ValidatorFn {
    console.log(control);
    console.log(control.value);
    console.log(this.departmentService.getByName(control.value));

    if(this.departmentService.getByName(control.value) != null){
      return ;
    }
    return null;
  }*/

}
