import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpeciesPutComponent } from './species-put.component';

describe('SpeciesPutComponent', () => {
  let component: SpeciesPutComponent;
  let fixture: ComponentFixture<SpeciesPutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SpeciesPutComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SpeciesPutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
