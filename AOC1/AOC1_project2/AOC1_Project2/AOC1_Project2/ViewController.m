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
    






    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
} //closing brace for background parent

//Leave the rest of the code from here alone


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
