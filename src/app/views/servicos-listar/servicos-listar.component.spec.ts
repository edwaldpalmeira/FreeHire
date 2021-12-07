import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServicosListarComponent } from './servicos-listar.component';

describe('ServicosListarComponent', () => {
  let component: ServicosListarComponent;
  let fixture: ComponentFixture<ServicosListarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServicosListarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ServicosListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
