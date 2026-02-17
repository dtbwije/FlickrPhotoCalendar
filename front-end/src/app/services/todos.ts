import { Injectable } from '@angular/core';
import { Todo } from '../model/todo.type'

@Injectable({
  providedIn: 'root',
})
export class Todos {
  todoItems: Array<Todo> = [{
    title : 'Groceries',
    id: 0,
    userId: 0,
    completed:false,
  }, {
     title: 'Carwash',
     id : 1,
     userId: 1,
     completed: false,
  }]

  constructor(){}
}
