<h3>Waste Classification Andorid App</h3>
<h1>CAPSTONE PROJECT by C22PC385</h1>

<h2>How to Use The App</h2>

1. Open the app
2. Take a picture of an object
3. See the result
<h2>Machine Learning Part</h2>
Download the dataset we used <a href="https://drive.google.com/file/d/1-3kxVWliKlJ5P_sovcmV5BjhCl5Eczr5/view?usp=sharing" target="_blank">here</a>. <br>
See the Jupyter Notebook <a href="https://github.com/aldirhmadi/capstone_project-WasteClassificationApps/blob/main/Machine%20Learning/waston_inceptionv3.ipynb" target="_blank">here</a>. <br>
Content of Jupyter Notebook:

1. Import libraries
2. Import dataset <br>
The dataset contains of 11 classes of images, which are battery, cardboard, clothes, e-waste, food, glass, light bulbs, metal, paper, plastic, and shoes.
4. Image preprocessing using ImageDataGenerator
5. Build the model structure with [InceptionV3](https://www.tensorflow.org/api_docs/python/tf/keras/applications/inception_v3/InceptionV3) pre-trained model and addition layers (dense layer with an output size of 11 and activation of softmax as the last layer)
6. Compile and train the model
7. Plot validation accuracy and loss
8. Model testing
9. Save model into .h5 format and TFLite (additional)
10. Load the .h5 format saved model and retrain it

<h2>Cloud Computing Part</h2>

1. Activate Cloud Run API and Cloud Build API
2. Container image to package resources (model.h5, Flask RestFul API)  using Dockerfile
3. Build with Cloud Build and deploy it to Cloud Run
4. API endpoints: https://getpredict-ehmfuclc5q-et.a.run.app
5. The mapping prediction results into 3 categories: <br>
Organik (Organic): food, cardboard, paper <br> 
Anorganik (Inorganic): clothes, glass, light bulbs, metal, plastic, shoes <br>
B3 (Toxic and Hazardous Material): battery, e-waste <br>


<h2>Mobile Development (Android) Part</h2>

1. Capture image using CameraX
2. Call the endpoint API with the image as a key
3. Display the result
