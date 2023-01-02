void setup() {
  size(800, 600);
  colorMode(RGB, 1);
}

void draw() {
  background(255);
  
  float w = 5;
  float h = (w * height) / width;
  
  float xMin = -w / 2;
  float yMin = - h / 2;
  
  loadPixels();
  
  int maxIterations = 100;
  
  float xMax = xMin + w;
  float yMax = yMin + h;
  
  float dx = (xMax - xMin) / (width);
  float dy = (yMax - yMin) / (height);
  
  float y = yMin;
  for (int j = 0; j < height; j++) {
    float x = xMin;
    for (int i = 0; i < width; i++) {
      
      float a = x;
      float b = y;
      int n = 0;
      while (n < maxIterations) {
        float aSquared = a * a;
        float bSquared = b * b;
        float twoab = 2.0 * a * b;
        a = aSquared - bSquared + x;
        b = twoab + y;
        if (((aSquared * aSquared) + (bSquared * bSquared)) > 16.0) {
          break;
        }
        n++;
      }
      
      if (n == maxIterations) {
        pixels[i + j * width] = color(0);    
      } else {
          pixels[i + j * width] = color(sqrt(float(n) / maxIterations));  
      }
      x += dx;
    }
    y += dy;
  }
  updatePixels();
}
