import { Component, inject , OnInit, signal } from '@angular/core';
import { Todos as TodosService }  from '../services/todos'
import { Todo as TodoModel } from '../model/todo.type'

@Component({
  selector: 'app-todos',
  imports: [],
  templateUrl: './todos.html',
  styleUrl: './todos.css',
})
export class Todos  implements OnInit {
  todoService = inject(TodosService)
  todoItems = signal<Array<TodoModel>>([])

  ngOnInit(): void {
    console.log(this.todoService.todoItems)
    this.todoItems.set(this.todoService.todoItems);
  }

}
