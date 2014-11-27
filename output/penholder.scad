difference () {
  union () {
    difference () {
      union () {
        rotate (a=0.0, v=[0, 0, 1]) {
          union () {
            translate ([12.5, 0, 0]) {
              cube ([25.0, 10, 10], center=true);
            }
            translate ([25.0, 0, 0]) {
              cylinder ($fn=32, h=10, r=5, center=true);
            }
          }
        }
        rotate (a=119.99999999999999, v=[0, 0, 1]) {
          union () {
            translate ([12.5, 0, 0]) {
              cube ([25.0, 10, 10], center=true);
            }
            translate ([25.0, 0, 0]) {
              cylinder ($fn=32, h=10, r=5, center=true);
            }
          }
        }
        rotate (a=239.99999999999997, v=[0, 0, 1]) {
          union () {
            translate ([12.5, 0, 0]) {
              cube ([25.0, 10, 10], center=true);
            }
            translate ([25.0, 0, 0]) {
              cylinder ($fn=32, h=10, r=5, center=true);
            }
          }
        }
      }
      translate ([0, 0, 4]) {
        cylinder (h=10, r=50.0, center=true);
      }
    }
    union () {
      translate ([8.0, 0, 10.0]) {
        rotate (a=29.999999999999996, v=[1, 0, 0]) {
          rotate (a=90.0, v=[0, 1, 0]) {
            intersection () {
              cylinder ($fn=6, h=15, r=8.5, center=true);
              cylinder ($fn=64, h=15, r=8.095238095238095, center=true);
            }
          }
        }
      }
      translate ([10.5, 0, 0]) {
        cube ([10, 10, 10], center=true);
      }
      translate ([0, 0, 10.0]) {
        intersection () {
          rotate (a=29.999999999999996, v=[0, 0, 1]) {
            cylinder ($fn=6, h=30, r1=17.0, r2=8.5, center=true);
          }
          cylinder ($fn=64, h=30, r1=16.15, r2=8.075, center=true);
        }
      }
    }
  }
  translate ([10.909090909090908, 0, 12]) {
    cube ([3.5, 7.5, 15.0], center=true);
  }
  rotate (a=0.0, v=[0, 0, 1]) {
    translate ([25.0, 0, 0]) {
      cylinder ($fn=32, h=20, r=2.1, center=true);
    }
  }
  rotate (a=119.99999999999999, v=[0, 0, 1]) {
    translate ([25.0, 0, 0]) {
      cylinder ($fn=32, h=20, r=2.1, center=true);
    }
  }
  rotate (a=239.99999999999997, v=[0, 0, 1]) {
    translate ([25.0, 0, 0]) {
      cylinder ($fn=32, h=20, r=2.1, center=true);
    }
  }
  cylinder ($fn=6, h=100, r=7.0, center=true);
  translate ([20, 0, 10]) {
    rotate (a=90.0, v=[0, 1, 0]) {
      cylinder ($fn=32, h=40, r=2, center=true);
    }
  }
  rotate (a=59.99999999999999, v=[0, 0, 1]) {
    translate ([19.805, 0, 20]) {
      cylinder ($fn=6, h=125, r=10, center=true);
    }
  }
  rotate (a=119.99999999999999, v=[0, 0, 1]) {
    translate ([19.805, 0, 20]) {
      cylinder ($fn=6, h=30, r=10, center=true);
    }
  }
  rotate (a=180.0, v=[0, 0, 1]) {
    translate ([19.805, 0, 20]) {
      cylinder ($fn=6, h=125, r=10, center=true);
    }
  }
  rotate (a=239.99999999999997, v=[0, 0, 1]) {
    translate ([19.805, 0, 20]) {
      cylinder ($fn=6, h=30, r=10, center=true);
    }
  }
  rotate (a=299.99999999999994, v=[0, 0, 1]) {
    translate ([19.805, 0, 20]) {
      cylinder ($fn=6, h=125, r=10, center=true);
    }
  }
}
