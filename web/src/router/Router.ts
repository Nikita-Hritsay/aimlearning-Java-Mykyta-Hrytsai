import { Component } from "../components/Component";
import { DepartmentForm } from "../components/department/DepartmentForm";
import { DepartmentList } from "../components/department/DepartmentList";
import { EmployeeForm } from "../components/employee/EmployeeForm";
import { EmployeeList } from "../components/employee/EmployeeList";
import { EmployeeByDepartment } from "../components/employee/EmployeeByDepartment";
import { Formatter } from "../utils/Formatter";


export class Router {
    
    private urls: Map<string, Component>;

    constructor() {
        this.urls = new Map();
        this.urls.set("#department", new DepartmentList())
        this.urls.set("#departmentForm", new DepartmentForm());
        this.urls.set("#employee", new EmployeeList());
        this.urls.set("#employeeForm", new EmployeeForm());
        this.urls.set("#department/employee", new EmployeeByDepartment());
    }

    public getUrl(url: string) {
        location.hash = url;
        return this.urls.get(url.split("?")[0]).render(Formatter.parseUrl(url), new URLSearchParams(location.hash.split("?")[1]));
    }

}