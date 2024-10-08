import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ChildComponent } from './child/child.component';
@Component({
  selector: 'app-parent',
  standalone: true,
  imports: [CommonModule, FormsModule, ChildComponent],
  templateUrl: './parent.component.html',
  styleUrl: './parent.component.scss',
})
export class ParentComponent {
  onDelete(index: number) {
    this.users.splice(index, 1);
  }
  users: any = [
    {
      name: 'Ngo Duy Anh',
      email: 'ndanh@gmail.com',
      address: 'Hanoi',
    },
    {
      name: 'Mai Thi Huong',
      email: 'maihuong@gmail.com',
      address: 'Hanoi',
    },
  ];
  addUser() {
    this.users.push({ ...this.obj });
  }

  obj: any = {};
  constructor() {}
}
