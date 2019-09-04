import cv2
import sys

def main():
    fps = 60
    size = 128

    make_file_name = "hoge.mp4"

    dir_path = "frames/"

    make_movie(make_file_name,dir_path,size,fps)

def make_movie(make_file_name,dir_path,size,fps):
    '''
    連続した画像から動画を作成する
    '''
    fourcc = cv2.VideoWriter_fourcc("m","p","4","v")
    video = cv2.VideoWriter(make_file_name, fourcc, fps, (size, size))

    for i in range(1, 3601):
        img = cv2.imread(dir_path+str(i)+".png")
        img2 = cv2.resize(img, dsize=(size,size))
        video.write(img2)

    video.release()

if __name__=="__main__":
    main()
    sys.exit()
