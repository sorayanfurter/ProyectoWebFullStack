import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarRedesComponent } from './navbar-redes.component';

describe('NavbarRedesComponent', () => {
  let component: NavbarRedesComponent;
  let fixture: ComponentFixture<NavbarRedesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarRedesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarRedesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
