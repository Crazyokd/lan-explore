(null? '())

(null? '(a b c))


; 1
(define (abs n)
	(* n
	   (if (positive? n) 1 -1)))

(define (abs n)
    (cond ((> x 0) x)
          ((= x 0) 0)
          ((< x 0) (- x))))

(define (abs n)
    (cond ((< x 0) (- x))
          (else x)))
; 2
(define (inv n)
	(if (not (zero? n))
		(/ n) ; n为除数，被除数默认为1
		#f))


; 3
(define (i2a n)
	(if (<= 33 n 126)
		(integer->char n)
		#f))


(and #f 0)

(and 1 2 3)


; last practice
(define (score n)
	(cond
		((>= n 80) 'A)
		((<= 60 n 79) 'B)
		((<= 40 n 59) 'C)
		(else 'D)))


