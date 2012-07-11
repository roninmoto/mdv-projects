//
//  ViewController.m
//  AOC1_Project2
//
//  Created by Joel Betterly on 7/11/12.
//  Copyright (c) 2012 Full Sail. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
//Add all code here for buttons

//Step 1 [View] Change background color.
{
    self.view.backgroundColor = [UIColor brownColor];

//Step 1 [Book Information and UILabels] create a UILabel and place it at the top. Center the text.
//Make sure to add variables to the ViewController.h file for each variable/button you make.
    
    titleOfBook = [[UILabel alloc] initWithFrame:CGRectMake(10, 10, 300, 40)];
    if (titleOfBook !=nil) {
        titleOfBook.text = @"The Stand";
        titleOfBook.textColor = [UIColor whiteColor];
        titleOfBook.backgroundColor = [UIColor blueColor];
        titleOfBook.textAlignment = UITextAlignmentCenter;
    }
    [self.view addSubview:titleOfBook];
    
//Step 2 Create another label that contains the text "Author:" with the text justified right.
//copy/paste from above and just change variable.  Change colors and lable size to match demo.png

    author = [[UILabel alloc] initWithFrame:CGRectMake(10, 70, 100, 25)];    
    if (author !=nil) {
        author.text = @"Author: ";
        author.textColor = [UIColor whiteColor];
        author.backgroundColor = [UIColor blueColor];
        author.textAlignment = UITextAlignmentRight;
    }
    [self.view addSubview:author];
    
//Step 3 Create a UILabel to the right of the author with text justified left.    
//Copy/Paste from above change coordinates and colors     

    authorName = [[UILabel alloc] initWithFrame:CGRectMake(115, 70, 200, 25)];    
    if (authorName !=nil) {
        authorName.text = @"Stephen King";
        authorName.textColor = [UIColor whiteColor];
        authorName.backgroundColor = [UIColor blueColor];
        authorName.textAlignment = UITextAlignmentLeft;
    }
    [self.view addSubview:authorName];

//Step 4 Create a uilabel on next line called "Published: " Text right justified.
//Copy/paste step two change variable and colors
    
    published = [[UILabel alloc] initWithFrame:CGRectMake(10, 110, 100, 25)];    
    if (published !=nil) {
        published.text = @"Published: ";
        published.textColor = [UIColor whiteColor];
        published.backgroundColor = [UIColor blueColor];
        published.textAlignment = UITextAlignmentRight;
    }
    [self.view addSubview:published];    
//Step 5 Create a label next to the published label and add the text of when the book was publisjed, left justify text.
//Copy/Paste, change variable and colors and coordinates just like above.

    publishedDate = [[UILabel alloc] initWithFrame:CGRectMake(115, 110, 200, 25)];    
    if (publishedDate !=nil) {
        publishedDate.text = @"September 1978";
        publishedDate.textColor = [UIColor whiteColor];
        publishedDate.backgroundColor = [UIColor blueColor];
        publishedDate.textAlignment = UITextAlignmentLeft;
    }
    [self.view addSubview:publishedDate]; 
    
    
    
    
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
} //closing brace for background parent

//Leave the rest of the code from here down alone


- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
    } else {
        return YES;
    }
}

@end
